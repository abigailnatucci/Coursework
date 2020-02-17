# Author: Abigail Natucci
# Class: CSCI 343 - L01

import re
from PIL import Image, ImageDraw, ImageDraw2

def read_stars(file):
    f = open(file, 'r')
    coordinates = {}
    brightness = {}
    names = {}
    for line in f:
        row = line.split()
        x = row[0]
        y = row[1]
        henryDraperNum = row[3]
        mag = row[4]
        harvardNum = row[5]
        if len(row) > 6:
            search = re.search('[A-Za-z]', line)
            first = search.start()
            starNames = line[first:].split(";")
            for name in starNames:
                name = name.lstrip()
                name = name.rstrip()
                names[name] = henryDraperNum
        coordinates[henryDraperNum] = (x,y)
        brightness[henryDraperNum] = mag
    f.close()
    return coordinates, brightness, names

def to_pixel_coords(xy, size):
    newCoordinate = ((-1 - xy[0]) * size[0]/2, (((1 - xy[1]) * size[1]/2) * -1))
    return newCoordinate

def plot_stars(draw, size, stars, magnitudes):
    #draw.line([(-200,-100), (-300,-400)], (255,255,255))
    for s in stars:
        x = float(stars[s][0])
        y = float(stars[s][1])
        coords = to_pixel_coords((x,y), size)
        #print(coords)
        x_coord = int(round(coords[0] * (-1), 0))
        y_coord = int(round(coords[1] * (-1), 0))
        #print(coords)
        b = float(magnitudes[s])
        c = int(round((255 * (1 - (b/10))), 0))
        draw.rectangle([(x_coord, y_coord), (x_coord+2, y_coord+2)], (c,c,c))
    return draw

def test():
    size = (1000,1000) # width = 512, height = 512
    background = (0,0,0) # Background color (black)
    image = Image.new('RGB', size, background)
    draw = ImageDraw.Draw(image)
    green = (0,255,0)
    red = (255,0,0)
    draw.rectangle( [(10,10), (200,300)], fill=green )
    draw.ellipse( [(300,300), (400,500)], fill=red)
    draw.line( [(50,500), (500,50)], fill=(255,255,255))
    image.save("out.png")

def read_constellations(file2):
    constellation_file = open(file2, 'r')
    constellations = list()
    for line in constellation_file:
        li=line.strip()
        if not li.startswith("#"):
            pair = li.split(',')
            star1 = pair[0]
            star2 = pair[1]
            constellation = (star1, star2)
            constellations.append(constellation)
            #print(constellations)
    constellation_file.close()
    return constellations

def plot_constellations(draw, size, stars, names, constellations):
    for c in constellations:
        name1 = c[0]
        name2 = c[1]
        hdn1 = names[name1]
        hdn2 = names[name2]
        star1_x = float(stars[hdn1][0])
        star1_y = float(stars[hdn1][1])
        star2_x = float(stars[hdn2][0])
        star2_y = float(stars[hdn2][1])
        star1_coords = to_pixel_coords((star1_x, star1_y), size)
        star1_x_coord = int(round(star1_coords[0] * (-1), 0))
        star1_y_coord = int(round(star1_coords[1] * (-1), 0))
        star2_coords = to_pixel_coords((star2_x, star2_y), size)
        star2_x_coord = int(round(star2_coords[0] * (-1), 0))
        star2_y_coord = int(round(star2_coords[1] * (-1), 0))
        draw.line([(star1_x_coord, star1_y_coord), (star2_x_coord, star2_y_coord)], fill=(157, 193, 131))
    return draw
        

canvas_Size = (1000,1000)
background = (0,0,0)
image = Image.new('RGB', canvas_Size, background)
draw = ImageDraw.Draw(image)
read = read_stars("stars.txt")
draw = plot_stars(draw, canvas_Size, read[0], read[1])
#test()
constellation_dict = read_constellations("constellations.txt")
draw = plot_constellations(draw, canvas_Size, read[0], read[2], constellation_dict)
image.save("out.png")
