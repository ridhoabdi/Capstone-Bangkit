import tensorflow as tf
import numpy as np
import matplotlib.image as mpimg

def get_category(img):
    """Write a Function to Predict the Class Name
    Args:
        img [jpg]: image file with 3 color channels
    Returns:
        [str]: Prediction
        [str]: Presentase
    """
    tflite_model_file = 'N:/A PROJECT S1/Semester 6/1. BANGKIT/Capstone ML/Skin-Diagnose2/2skin_model.tflite'
    with open(tflite_model_file, 'rb') as fid:
        tflite_model = fid.read()
    interpreter = tf.lite.Interpreter(model_content=tflite_model)
    interpreter.allocate_tensors()

    input_details = interpreter.get_input_details()
    output_details = interpreter.get_output_details()

    # Read an image from a file into a numpy array
    img = mpimg.imread(img)
    # Convert to float32
    img = tf.cast(img, tf.float32)
    # Resize to 224x224 (size the model is expecting)
    img = tf.image.resize(img, [224, 224])
    # Expand img dimensions from (224, 224, 3) to (1, 224, 224, 3) for set_tensor method call
    images = np.expand_dims(img, axis=0)


    interpreter.set_tensor(input_details[0]['index'], images)

    interpreter.invoke()

    prediction = interpreter.get_tensor(output_details[0]['index'])
    predicted_label = np.argmax(prediction, axis=1)

    persentase = "{:.2f}".format(np.max(prediction)*100)
    class_names = ['chickenpox', 'Scabies']
    Prediction = class_names[predicted_label[0]]
    
    return Prediction, persentase

