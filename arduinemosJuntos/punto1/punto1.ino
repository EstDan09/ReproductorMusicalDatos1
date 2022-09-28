int LikeButton = 0;
int Likepulso = 0;

int PrevButton = 1;
int Prevpulso = 0;

int PlayButton = 2;
int Playpulso = 0;

int PauseButton = 3;
int Pausepulso = 0;

int NextButton = 4;
int Nextpulso = 0;

int ResetButton = 5;
int Resetpulso = 0;



void setup() {
  pinMode(LikeButton, INPUT);
  Serial.begin(9600);
  pinMode(PrevButton, INPUT);
  Serial.begin(9600);
  pinMode(PlayButton, INPUT);
  Serial.begin(9600);
  pinMode(PauseButton, INPUT);
  Serial.begin(9600);
  pinMode(NextButton, INPUT);
  Serial.begin(9600);
  pinMode(ResetButton, INPUT);
  Serial.begin(9600);
}

void loop() {
  Likepulso = digitalRead(LikeButton);
  if (Likepulso == LOW){
    Serial.print("a");
    delay(1000);
    }
  Prevpulso = digitalRead(PrevButton);
  if (Prevpulso == LOW){
    Serial.print("b");
    delay(1000);
    }
  Playpulso = digitalRead(PlayButton);
  if (Playpulso == LOW){
    Serial.print("c");
    delay(1000);
    }
  Pausepulso = digitalRead(PauseButton);
  if (Pausepulso == LOW){
    Serial.print("d");
    delay(1000);
    }
  Nextpulso = digitalRead(NextButton);
  if (Nextpulso == LOW){
    Serial.print("e");
    delay(1000);
    }
  Resetpulso = digitalRead(ResetButton);
  if (Resetpulso == LOW){
    Serial.print("f");
    delay(1000);
    }
}
