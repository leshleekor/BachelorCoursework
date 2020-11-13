// Song: Piano Man - Billy Joel
// Part: Chorus
0.4::second => dur beat;
beat / 5 => dur rest;

beat - rest => dur en;
rest => dur en_rest;

en / 2 => dur sn;
rest / 2 => dur sn_rest;

en * 2 => dur qn;
rest * 2 => dur qn_rest;

0.3 => float on;
0.0 => float off;

// [60, 62, 64, 65, 67, 69, 71, 72]
// [72, 74, 76, 77, 79]

[79, 79, 79, 79, 77, 76, 77, 76, 72, -1] @=> int notes1[];
[sn, sn+en, sn, sn+qn, sn, sn, sn, en, sn+en, qn+en] @=> dur durs1[];
[sn_rest, sn_rest+en_rest, sn_rest, sn_rest+qn_rest, sn_rest, sn_rest, sn_rest, en_rest, sn_rest+en_rest, qn_rest+en_rest] @=> dur rest1[];

[69, 72, 72, 72, 74, 74, -1, 76, 77, 79, 79, 79, 79, 77, 76, 77, 76, 72, -1] @=> int notes2[];
[sn, sn+en, sn, sn+qn, sn, sn+(qn*1.5), qn, sn, sn, en, en, sn, en+sn, en+sn, sn, sn, sn, qn, qn] @=> dur durs2[];
[sn_rest, sn_rest+en_rest, sn_rest, sn_rest+qn_rest, sn_rest, sn_rest+(qn_rest*1.5), qn_rest, sn_rest, sn_rest, en_rest, en_rest, sn_rest, en_rest+sn_rest, en_rest+sn_rest, sn_rest, sn_rest, sn_rest, qn_rest, qn_rest] @=> dur rest2[];

[-1, 67, 69, 72, 72, 77, 76, 72, 72, -1] @=> int notes3[];
[sn, sn, en, sn, sn+en, sn, sn, qn, qn+en, qn+en] @=> dur durs3[];
[sn_rest, sn_rest, en_rest, sn_rest, sn_rest+en_rest, sn_rest, sn_rest, qn_rest, qn_rest+en_rest, qn_rest+en_rest] @=> dur rest3[];

SinOsc s => dac;

for (0 => int i; i < notes1.cap(); i++) {
  if(notes1[i] == -1)
    off => s.gain;
  else {
    Std.mtof(notes1[i]) => s.freq;
    on => s.gain;
  }
  durs1[i] => now;
  off => s.gain;
  rest1[i] => now;
}

for (0 => int i; i < notes2.cap(); i++) {
  if(notes2[i] == -1)
    off => s.gain;
  else {
    Std.mtof(notes2[i]) => s.freq;
    on => s.gain;
  }
  durs2[i] => now;
  off => s.gain;
  rest2[i] => now;
}

for (0 => int i; i < notes3.cap(); i++) {
  if(notes2[i] == -1)
    off => s.gain;
  else {
    Std.mtof(notes3[i]) => s.freq;
    on => s.gain;
  }
  durs3[i] => now;
  off => s.gain;
  rest3[i] => now;
}