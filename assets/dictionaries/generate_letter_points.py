'''
Calculates appropriate letter scores for IPA chars based on the frequency of each char in the IPA dictionary.
'''

import argparse
import collections
import json
import math

MAX_SCORE = 16
MONOPHONEMES = 'iuæɑɔəɚɛɪʊ' + 'bdfhjklmnpstvwzðŋɡɹʃʒθ'
DIPHONEMES = ['ij', 'uw', 'ej', 'ɔj', 'ow', 'aj', 'aw']

def main():
	parser = argparse.ArgumentParser()
	parser.add_argument('-d', '--dict_path', default='dictionary.en_IPA.txt')
	parser.add_argument('-j', '--json_path')
	args = parser.parse_args()

	with open(args.dict_path) as prons_file:
		prons = [line[:-1] for line in prons_file]

	monophoneme_counts = collections.defaultdict(int)
	diphoneme_counts = collections.defaultdict(int)
	for pron in prons:
		for phoneme in pron:
			if phoneme in MONOPHONEMES:
				monophoneme_counts[phoneme] += 1
		for phoneme in DIPHONEMES:
			diphoneme_counts[phoneme] += pron.count(phoneme)
	for diphoneme, diphoneme_count in diphoneme_counts.items():
		for monophoneme in diphoneme:
			monophoneme_counts[monophoneme] -= diphoneme_count

	phoneme_counts = {pho: count for pho, count in (monophoneme_counts | diphoneme_counts).items() if count > 0}

	total = sum(phoneme_counts.values())
	# Scale factor is chosen such that the least frequent phoneme will be worth MAX_SCORE points
	scale_factor = (min(phoneme_counts.values()) / total) * MAX_SCORE
	tiles_to_points = {phoneme: math.ceil((total / count) * scale_factor) for phoneme, count in phoneme_counts.items()}
	points_to_tiles = collections.defaultdict(list)
	for phoneme, poi in tiles_to_points.items():
		points_to_tiles[poi].append(phoneme)

	# Intentionally print out point values for which there are no tiles in order to visually represent the distance between low and high value tiles.
	for poi in range(1, MAX_SCORE + 1):
		print(f'{poi}: {", ".join(points_to_tiles[poi])}')
	tile_sum = sum(poi * len(phonemes) for poi, phonemes in points_to_tiles.items())
	tile_average = round(tile_sum / sum(len(phonemes) for phonemes in points_to_tiles.values()), 3)
	print(f'Average of {tile_average} points per phoneme.')

	if args.json_path:
		with open('ipa_points.json', 'w') as out_file:
			json.dump(tiles_to_points, out_file, indent='\t')

if __name__ == '__main__':
	main()
