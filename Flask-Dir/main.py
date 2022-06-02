from flask import Flask, jsonify, request, render_template
from upload import get_category
from test import get_url
from datetime import datetime
import json

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def rock_paper_scissor():
    if request.method == 'POST':
    # POST method to post the results file
        # Read file from upload
        img = request.files['file']
        # Get category of prediction
        image_category = get_category(img)

        # current_time = now.strftime("%H-%M-%S")
        # plot_category(img, current_time)
        # Render the result template
        # return render_template('result.html', category=image_category, current_time=current_time)
        label = ['Prediksi','Persentase']
        data = {label[i] : image_category[i] for i in range(len(label))}
        with open ('data.json', 'w') as f:
            json.dump(data, f, indent=4)

        
    # For GET requests, load the index file
    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)