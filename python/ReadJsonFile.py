import json
import sys
import datetime

with open(sys.argv[1]) as json_file:
    data = json.load(json_file)
    for p in data:
        print('phaseName: ' + str(p['phaseName']))
        if(p['startTime'] == None):
            print('null')
        else:
            print('startTime: ' + datetime.datetime.fromtimestamp(p['startTime']/1000).strftime('%Y-%m-%d %H:%M:%S'))
        if(p['endTime'] == None):
            print('null')
        else:
            print('endTime: ' + datetime.datetime.fromtimestamp(p['endTime']/1000).strftime('%Y-%m-%d %H:%M:%S'))
        print('---------------------------')
