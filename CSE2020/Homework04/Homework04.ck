// Piano
Rhodey p => dac;

77 => float speed;
(60/speed)::second => dur quar;

SndBuf kick => Gain master => dac;
SndBuf snare => master;
me.dir() + "/audio/kick_01.wav" => kick.read;
me.dir() + "/audio/snare_01.wav" => snare.read;

[
66, 64, 62, 61, 57, 59, 57, 55, 54, 59, 55, 59, 61, 74, 76, // 1~4
78, 76, 79, 78, 76, 74, 76, 74, 73, 69, 71, 69, 67, 66, 62, 71, 67, 71, 73, // 5~8
69, 69, 66, 66, 62, 62, 62, 64, // 9~12
69, 69, 66, 66, 67, 66, 67, 64, 64 // 13~16 + 17
] @=> int pn[];
[
2.0, 2, 2, 4, 4, 4, 8, 8, 2, 4, 8, 8, 4, 8, 8, // 1~4
2, 8, 8, 8, 8, 4.5, 16, 16, 4, 4, 4, 8, 8, 4, 4, 4, 8, 8, 2,// 5~8
2, 2, 2, 2, 2, 2, 2, 2, // 9~12
2, 2, 2, 2, 2, 2, 2, 2, 1 // 13~16 + 17
] @=> float pd[];

0.5 => float on;
0.0 => float sum;

<<< quar*4 >>>;

for(0 => int i; i < pn.cap(); i++) {
  Std.mtof(pn[i]) => p.freq;
  if(pn[i] == 0) {
    1 => p.noteOff;
  } else {
    1 => p.noteOn;
  }
  on => p.gain;
  beatKick(sum);
  beatSnare(sum);
  getDur(pd[i]) => now;
}

fun void beatKick(float sum) {
  if(sum - Math.floor(sum) > 0.9) {
    Math.ceil(sum) => sum;
  }
  Std.ftoi(sum) => int b;
  if(b % 4 == 0) {
    0 => kick.pos;
    0 => sum;
  } 
}

fun void beatSnare(float sum) {
  Std.ftoi(sum) => int b;
  if(b == 0) {
    return;
  }
  if(b % 4 == 2) {
    0 => snare.pos;
  }
}

// note
fun dur getDur(float note) {
  if(note == 4) { // 4
    sum+1 => sum;
    return quar;
  } else if(note == 8) { // 8
    sum+0.5 => sum;
    return (quar/2);
  } else if(note == 2) { // 2
    sum+2 => sum;
    return (quar*2);
  } else if(note == 16) { // .16
    sum+0.25 => sum;
    return (quar/4);
  } else if(note == 1) { // 1
    sum+4 => sum;
    return (quar*4);
  } else if(note == 4.5) { // .4 
    sum+1.5 => sum;
    return (quar*1.5);
  } else if(note == 2.5) { // .2
    sum+3 => sum;
    return (quar*3);
  } else if(note == 8.3) { // 8
    sum+0.1666 => sum;
    return (quar/6);
  }
}