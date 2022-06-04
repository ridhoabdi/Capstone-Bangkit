from distutils.log import debug
from operator import index
from flask import Flask, jsonify, request, render_template
from matplotlib import image
from upload import get_category
from test import get_url
from datetime import datetime
import json
import matplotlib.pyplot as plt

app = Flask(__name__)


@app.route("/")
def showHomePage():
    return "This is home page"


# @app.route('/', methods=['GET', 'POST'])
@app.route('/Upload', methods=['POST'])
def rock_paper_scissor():
    if request.method == 'POST':
        # POST method to post the results file
        # Read file from upload
        img = request.files['file']
    # imgs = image.__loader__img(img)
    # plt.imshow(imgs)
    # plt.show()
    # Get category of prediction
        image_category = get_category(img)

    # current_time = now.strftime("%H-%M-%S")
    # plot_category(img, current_time)
    # Render the result template
    # return render_template('result.html', category=image_category, current_time=current_time)
        label = ['Prediksi', 'Persentase']
        data = {label[i]: image_category[i] for i in range(len(label))}
        with open('data.json', 'w') as f:
            json.dump(data, f, indent=4)

    # return()

    # For GET requests, load the index file
    # return render_template('index.html')
    # return get_url('127.0.0.1:5000')


if __name__ == '__main__':
    # app.run(debug=True)
    app.run(host="0.0.0.0")