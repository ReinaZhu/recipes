import json
import csv

with open('db-recipes.json') as json_file:
	jsondata = json.load(json_file)

data_file = open('db-recipes.csv', 'w', newline='')
csv_writer = csv.writer(data_file)

count = 0
csv_writer.writerow(jsondata["2"].keys())

for data in jsondata:
	dic = jsondata[data]
	str = []
	count += 1
	for item in dic:
		str.append(dic[item])
	str[0] = count
	csv_writer.writerow(str)

data_file.close()
