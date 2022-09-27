int LedA = 8;
int ButtonPlay = 7;
int pulsoPlay = 0;

int ButtonPause = 6;
int pulsoPause = 0;

int ButtonNext = 5;
int pulsoNext = 0;

int ButtonPrev = 4;
int pulsoPrev = 0;

int ButtonLikear = 3;
int pulsoLikear = 0;




void setup() {
  pinMode(ButtonPlay, INPUT);
  Serial.begin(9600);
}

void loop() {
  pulsoPlay = digitalRead(ButtonPlay);
  if (pulsoPlay == HIGH){
    Serial.print("p");
    delay(1000);
    }
    
  pulsoPause = digitalRead(ButtonPause);
  if (pulsoPause == HIGH){
    Serial.print("i");
    delay(1000);
    }
    
  pulsoNext = digitalRead(ButtonNext);
  if (pulsoNext == HIGH){
    Serial.print("n");
    delay(1000);
    }
    
  pulsoPrev = digitalRead(ButtonPrev);
  if (pulsoPrev == HIGH){
    Serial.print("g");
    delay(1000);
    }

  pulsoLikear = digitalRead(ButtonLikear);
  if (pulsoPlay == HIGH){
    Serial.print("a");
    delay(1000);
    }
}
