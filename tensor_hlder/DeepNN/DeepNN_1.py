import tensorflow as tf
import numpy as np
'''
학습데이터 입력 
w = 가중치, b 편향 나누어서 선언한다.
1 번째 은닉층은 10개의 노드와 뉴런으로 선언한다. W1 = [특성, 뉴런의 갯수]
2 번쨰 은닉층은 10가지의 특성과 3개의 뉴런으로 은닉층을 구성한다.
'''
x_source = np.array([[0, 0], [1, 0], [1, 1], [0, 0], [0, 0], [0, 1]])
y_source = np.array([[1, 0, 0], [0, 1, 0], [0, 0, 1], [1, 0, 0], [1, 0, 0], [0, 0, 1]])

X = tf.placeholder(tf.float32)
Y = tf.placeholder(tf.float32)

W1 = tf.Variable(tf.random_uniform([2, 10], -1., 1.))
W2 = tf.Variable(tf.random_uniform([10, 3], -1., 1.))

b1 = tf.Variable(tf.zeros([10]))
b2 = tf.Variable(tf.zeros([3]))
'''
은닉층을 2개 사용하기에 첫번째에서 활성함수 선언한다.
2번째에 model 에 은닉층을 선언하고 최종 결과를 받는다.
'''
L1 = tf.add(tf.matmul(X, W1), b1)
L1 = tf.nn.relu(L1)
model = tf.add(tf.matmul(L1, W2), b2)
'''
최적화 하기 위해서 비용합수를 작성한다. cross_entropy 명령어로 비용함수를 최적화 시켜준다.
'''
cost = tf.reduce_mean(
    tf.nn.softmax_cross_entropy_with_logits(labels=Y, logits=model))
'''
심층 신경망으로 구성된 모델을 학습 시킨다.
'''
optimizer = tf.train.AdamOptimizer(learning_rate=0.01)
train_op = optimizer.minimize(cost)

init = tf.global_variables_initializer()
sess = tf.Session()
sess.run(init)

for step in range(500):
    sess.run(train_op, feed_dict={X: x_source, Y: y_source})

    if (step + 1) % 10 == 0:
        print(step+1, sess.run(cost, feed_dict={X: x_source, Y: y_source}))
'''
결과를 확인하는 출력문이다 (없어도 무관하다)
'''
prediction = tf.argmax(model, 1)
target = tf.argmax(Y, 1)
print('예측 값 :', sess.run(prediction, feed_dict={X: x_source, Y: y_source}))
print('결과 값 :', sess.run(target, feed_dict={X: x_source, Y: y_source}))

is_correct = tf.equal(prediction, target)
accuracy = tf.reduce_mean(tf.cast(is_correct, tf.float32))
print('정확도 %.2f' % sess.run(accuracy * 100, feed_dict={X: x_source, Y: y_source}))
