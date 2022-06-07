import requests

path = 'N:/A PROJECT S1/Semester 6/1. BANGKIT/Capstone ML/Skin-Diagnose/test/'
resp = requests.post("http://127.0.0.1:5000", files={'file': open(path + 'skindisease2.jpg', 'rb')})

print(resp.json())