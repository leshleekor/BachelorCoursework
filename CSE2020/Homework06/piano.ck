// Piano
Rhodey p => dac;

120 => float speed;
(60/speed)::second => dur quar;

// 48도, 50레, 52미, 53파, 55솔, 57라, 59시,
// 60도, 62레, 64미, 65파, 67솔, 69라, 71시, 72도
// 72도, 74레, 76미, 77파, 79솔, 81라
[
66, 64, 62, 61, 57, 59, 57, 55, 54, 59, 55, 59, 61, 74, 76, // 1~4 마디
78, 76, 79, 78, 76, 74, 76, 74, 73, 69, 71, 69, 67, 66, 62, 71, 67, 71, 73, // 5~8마디
69, 69, 66, 66, 62, 62, 62, 64, // 9~12마디
69, 69, 66, 66, 67, 66
// , 67, 64, 64 // 13~16마디 + 17마디
// 78, 0, 0, 76, 0, 0, 74, 0, 0, 73, 0, 0 // 18~21
// 71, 0, 0, 69, 0, 0, 71, 0, 0, 73, 0, 0 // 22~25
] @=> int pn[];

[
2.0, 2, 2, 4, 4, 4, 8, 8, 2, 4, 8, 8, 4, 8, 8, // 1~4 마디
2, 8, 8, 8, 8, 4.5, 16, 16, 4, 4, 4, 8, 8, 4, 4, 4, 8, 8, 2,// 5~8마디
2, 2, 2, 2, 2, 2, 2, 2, // 9~12마디
2, 2, 2, 2, 2, 2
// , 2, 2, 1 // 13~16마디 + 17마디
// 4.0, 4, 2, 4, 4, 2, 4, 4, 2, 4, 4, 2,
// 4, 4, 2, 4, 4, 2, 4, 4, 2, 4, 4, 2
] @=> float pd[];

0.5 => float on;
0.0 => float sum;

play(pn, pd);

fun void play(int notes[], float duration[]) {
  for(0 => int i; i < notes.cap(); i++) {
    Std.mtof(notes[i]) => p.freq;
    if(notes[i] == 0) {
      1 => p.noteOff;
    } else {
      1 => p.noteOn;
    }
    on => p.gain;
    getDur(duration[i]) => now;
  }
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