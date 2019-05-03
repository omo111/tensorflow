import os
os.environ['TF_CPP_MIN_LOG_LEVEL']='3'

import tensorflow as tf

hello = tf.constant("hello , tensorflow and PyChaem")
sess = tf.Session()

print(sess.run(hello))
print(str(sess.run(hello),encoding='utf-8'))