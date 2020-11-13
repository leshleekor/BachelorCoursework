Clarinet m => ADSR adsr => Gain input => NRev rev => dac;
Delay del[3];

input => del[0] => dac;
input => del[1] => dac.left;
input => del[2] => dac.right;


adsr.set(0.005::second, 0.001::second, 0.8, 0.001::second);
setDelay();
80.0 => float speed;
(60/speed)::second => dur quar;
0 => float sum;
0.5 => m.gain;
0.05 => rev.mix;

[78, 76, 74, 76, 78, 79, 78, 76, 78, 78, 78, 78, 74, 81, 81, 74, 69, 69, 69,
71, 74, 69, 71, 76, 78, 76, 73, 76, 78, 79, 78, 76, 78, 78, 78, 69, 83, 83, 81, 74, 76, 74, 74, 
69, 69, 74, 69, 74, 73, 74, 73, 74, 86, 76, 88, 88, 86, 85, 81, 69, 81, 83, 83, 83, 83, 85] @=> int notes[];
[8.0,8,8,8,8,8,8,8,8,8,8,4,8,8,4.5,4,4,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,4,4.5,8,8,8,4.5,
4, 8, 8, 8, 4.5, 4.5, 8, 8, 4.5, 4.5, 8, 8, 4, 8, 4, 4, 8, 4.5, 2.5, 4.5, 8, 4, 4] @=> float durNotes[];
<<< notes.cap(), durNotes.cap()>>>;

playLoop(76, 78, 8.0);
playLoop(76, 78, 8);
playLoop(76, 78, 8);

for(0 => int n; n < notes.cap(); n++) {
  playNote(notes[n], durNotes[n]);
}

fun void playLoop(int note1, int note2, float noteDur) {
  for(0 => int i; i<4; i++) {
    playNote(note1, noteDur);
    playNote(note2, noteDur);
  }
}

fun void playNote(int note, float noteDur) {
  Std.mtof(note) => m.freq;
  1 => m.noteOn;
  1 => adsr.keyOn;
  getDur(noteDur) => now;
  1 => m.noteOff;
  0.01::second => now;
}

fun dur getDur(float note) {
  if(note == 4) { // 4분음표
    sum+1 => sum;
    return quar;
  } else if(note == 8) { // 8분음표
    sum+0.5 => sum;
    return (quar/2);
  } else if(note == 2) { // 2분음표
    sum+2 => sum;
    return (quar*2);
  } else if(note == 16) { // 16분 음표
    sum+0.25 => sum;
    return (quar/4);
  } else if(note == 1) {
    sum+4 => sum;
    return (quar*4);
  } else if(note == 4.5) { // 점4분음표
    sum+1.5 => sum;
    return (quar*1.5);
  } else if(note == 2.5) { // 점2분음표
    sum+3 => sum;
    return (quar*3);
  } else if(note == 8.3) { // 8분음표 세잇단
    sum+0.1666 => sum;
    return (quar/6);
  }
}

fun void setDelay() {
  for(0 => int i; i < 3 ; i++) {
    del[i] => del[i];
    if(i > 0) {
      0.1 => del[i].gain;
    } else {
      0.6 => del[i].gain;
    }
    (0.5 + i*0.2) :: second => del[i].max => del[i].delay;
  }
}