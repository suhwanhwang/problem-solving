#! /usr/loca/bin/python3.5
"""
TEST
"""

tile = "LGL"
o = ""
for s in tile:
    if s == 'L':
        o += tile
    else:
        o += 'G' * len(tile)
print(o)
    