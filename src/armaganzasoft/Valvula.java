GPIO.setup(right_valvula, GPIO.IN, pull_up_down = GPIO.PUD_UP)
 
while True:
 if GPIO.input(left_valvula): 
print("LEFT VALVULA OPEN!")
 if GPIO.input(right_valvula): 
print("RIGHT VALVULA OPEN!")
 time.sleep(0.5) 
GPIO.cleanup( )



 import time

 import RPi.GPIO as GPIO

    public void close(){
    // the code

 GPIO.setmode(GPIO.BCM) 
left_valvula = 22
 right_valvula = 23 

 GPIO.setup(left_valvula, GPIO.IN, pull_up_down = GPIO.PUD_UP)
 GPIO.setup(right_valvula, GPIO.IN, pull_up_down = GPIO.PUD_UP) 

while True:
 if GPIO.input(left_valvula): 
print("LEFT VALVULA CLOSE!")
 if GPIO.input(right_valvula): 
print("RIGHT VALVULA CLOSE!")
 time.sleep(0.5) 
GPIO.cleanup( )


} 
    }
}
