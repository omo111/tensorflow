import tensorflow as tf
# x y 데이터 선언
x_data = [1, 2, 3, 4]
y_data = [3, 6, 9, 12]
# tf.random_uniform = 균등 분포 난수 생성
W = tf.Variable(tf.random_uniform([1]), name='weight')
b = tf.Variable(tf.random_uniform([1]), name='bias')
# placeholder 선언후에 데이터넣을 구역 만듬
X = tf.placeholder(tf.float32, name="X")
Y = tf.placeholder(tf.float32, name="Y")
# 가설 1차함수로 표현하게 예측 함
hypothesis = W * X + b

# cost = 손실 함수 선언
cost = tf.reduce_mean(tf.square(hypothesis - Y))
# 최소 비용 선언 경사 하강법 사용
optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.1)
# 비용함수와 경사하강법으로 학습텐서 선언
train = optimizer.minimize(cost)
# 선언한 그래프를 세션을 통하여서 학습
sess = tf.Session()
# 선언한 변수 초기화 필수
sess.run(tf.global_variables_initializer())
# for 문 이용해서 최적화
for step in range(100):
        train_val, cost_val = sess.run([train, cost], feed_dict={X: x_data, Y: y_data})
        print(step, cost_val, sess.run(W), sess.run(b))

print("test")
print("x : 10 , y : ", sess.run(hypothesis, feed_dict={X: [10]}))
print("x : 12 , y : ", sess.run(hypothesis, feed_dict={X: 12}))
