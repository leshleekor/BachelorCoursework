HevyMetl g => dac;

120 => float speed;
(60/speed)::second => dur quar;

[
0, 0, 0, 0, // 1~4 마디
0, 0, 0, 0, // 1~4마디 도돌이
78, 76, 74, 73, 71, 69, 71, 73, 74, 76, // 5~8
78, 76, 79, 78, 79, 78, 76, 74, 76, 74, 73, 78, 81, // 9마디 10마디
79, 78, 79, 78, 76, 79
// , 78, 76, 78, 76, 74, 73, 71, 69, 67, 74, 73, 0, // 11마디 12마디 13마디
// 74, 0, 0, 0, 79, 78, 0, 0
] @=> int gn[];
[
1.0, 1, 1, 1, // 1~4 마디
1, 1, 1, 1, // 1~4마디 도돌이
2, 2, 2, 2, 2, 2, 2, 4, 8, 8, // 5~8
2, 8, 8, 8.3, 8.3, 8.3, 8, 4.5, 16, 16, 8, 8, 4, // 9마디 10마디
8, 8.3, 8.3, 8.3, 8, 8, 8
//, 8.3, 8.3, 8.3, 8, 8, 8, 8, 8, 8, 2, 1 // 11마디 12마디 13마디
// 8.0, 8, 8, 8, 8, 8, 8, 8
] @=> float gd[];

0.22 => float on;

for(0 => int i; i < gn.cap(); i++) {
  Std.mtof(gn[i]) => g.freq;
  if(gn[i] == 0) {
    1 => g.noteOff;
  } else {
    1 => g.noteOn;
  }
  on => g.gain;
  getDur(gd[i]) => now;
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