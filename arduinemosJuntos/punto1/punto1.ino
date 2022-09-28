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
  if (Likepulso == HIGH){
    Serial.print("a");
    delay(1000);
    }
  Prevpulso = digitalRead(PrevButton);
  if (Prevpulso == HIGH){
    Serial.print("b");
    delay(1000);
    }
  Playpulso = digitalRead(PlayButton);
  if (Playpulso == HIGH){
    Serial.print("c");
    delay(1000);
    }
  Pausepulso = digitalRead(PauseButton);
  if (Pausepulso == HIGH){
    Serial.print("d");
    delay(1000);
    }
  Nextpulso = digitalRead(NextButton);
  if (Nextpulso == HIGH){
    Serial.print("e");
    delay(1000);
    }
  Resetpulso = digitalRead(ResetButton);
  if (Resetpulso == HIGH){
    Serial.print("f");
    delay(1000);
    }
}
