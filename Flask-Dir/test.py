import requests

def get_url(server):
    """Write a Function to post some picture
    Args:
        server [string]: alamat server 
    Returns:
        [str]: url post
    """

    path = 'N:/A PROJECT S1/Semester 6/1. BANGKIT/Capstone ML/Capstone-Bangkit-ML/Skin disease/Test/Chickenpox/'
    resp = requests.post('http://'+server, files={'file': open(path + '25.JPG', 'rb')})
    a = print(resp.json())
    return a

