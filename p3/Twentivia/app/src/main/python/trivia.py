#!/usr/bin/env python
#
#

import json
import requests

def getTrivia():
	url = "https://the-trivia-api.com/api/questions?"
	r = requests.get(url)
	result = json.loads(r.text)
	return result
		
		
	

