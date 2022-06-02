import requests
import os

def get_url(server):
    """Write a Function to post some picture
    Args:
        server [string]: alamat server 
    Returns:
        [str]: url post
    """

    path = 'N:/A PROJECT S1/Semester 6/1. BANGKIT/Capstone ML/Skin-Diagnose2/test/'
    resp = requests.post('http://'+server, files={'file': open(path + 'skindisease1.jpg', 'rb')})
    a = print(resp.json())
    return a

