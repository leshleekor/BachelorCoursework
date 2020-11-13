SndBuf kick => Gain master => dac;
SndBuf snare => master;
me.dir() + "/audio/kick_01.wav" => kick.read;
me.dir() + "/audio/snare_01.wav" => snare.read;
120 => float speed;
(60/speed)::second => dur quar;

[
2, 2, 2, 2, 2, 2, 2, 2, // 1~4 마디
2, 2, 2, 2, 2, 2, 2, 2, // 5~8마디
2, 2, 2, 2, 2, 2, 2, 2, // 9~12마디
2, 2, 2, 2, 2, 2 // 13~16마디 + 17마디
] @=> int pd[];

[
1, 0, 1, 0, 1, 0, 1, 0, 
1, 0, 1, 0, 1, 0, 1, 0, 
1, 0, 1, 0, 1, 0, 1, 0, 
1, 0, 1, 0, 1, 0
] @=> int pn[];

for(0 => int i; i < pn.cap(); i++) {
  if(pn[i] == 1) {
    0 => kick.pos;
  }
  if(pn[i] == 0) {
    0 => snare.pos;
  }
  getDur(pd[i]) => now;
}

// 박자 함수
fun dur getDur(float note) {
  if(note == 4) { // 4분음표
    return quar;
  } else if(note == 8) { // 8분음표
    return (quar/2);
  } else if(note == 2) { // 2분음표
    return (quar*2);
  } else if(note == 16) { // 16분 음표
    return (quar/4);
  } else if(note == 1) {
    return (quar*4);
  } else if(note == 4.5) { // 점4분음표
    return (quar*1.5);
  } else if(note == 2.5) { // 점2분음표
    return (quar*3);
  } else if(note == 8.3) { // 8분음표 세잇단
    return (quar/6);
  }
}