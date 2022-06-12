# Capstone-Bangkit-ML(Dermanosis)
The function of this repository is to documentation everything that ML team did at capstone project
Team id C22-PS039

## Google Colab Notebook
Feel experiment with our final notebook [here](https://colab.research.google.com/drive/18z39wPGyB9IWbrKQA4boUY-OX5Q_6EUt?usp=sharing)

## Dataset
Download or load our dataset [here](https://drive.google.com/u/0/uc?id=1EML4UmDgQFrVv7zbPpdoGp6JSHIg6fOX&export=download)

## Preparing and Training
- Using `ImageDataGenerator` to augmented the dataset and make better training proses
- Choose `MobilenetV2` transer learning as pretrained model
- Using `Adamax` as Optimizer
- Using `SparseCategoricalCrossentropy` as loss
- Adding more layer when using `tf.keras.Sequential` like:
  -  Add `Dense` layer with `32` unit and `relu` as activation
  -  Add `Dropout` layesr with 20% value to avoid overfitting
  -  Add `Dense` layer again with `32` unit and `relu` as activation
  -  And final layer using `Dense` with `3` unit and `softmax` as activation
- Defining `ModelCheckpoint` in every epochs and saved the best model with *.h5
- Training with  30 epoch
- Best model we got:
  - `loss: 53%`
  - `accuracy: 82%`
  - `val_loss: 46%`
  - `val_accuracy: 84%`

## The Model
[Here](https://drive.google.com/drive/folders/19YdGU8xvtLl_P3_C6Nb7_sR1FU7UOjjW?usp=sharing) our model documentation to get the best model we use
Download our best model [here](https://drive.google.com/file/d/107fvLNaXsLk2OTvCVbLQb-JrxHN_5Jpk/view?usp=sharing)


