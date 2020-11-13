261.6256 => float C4;
293.6648 => float D4;
329.6276 => float E4;
349.2282 => float F4;
391.9954 => float G4;
440 => float A4;
466.1638 => float Bb4;
493.8833 => float B4;

F4/2 => float F3;

0.3 => float volumes;
0.3::second => dur beat;

SinOsc s => dac;
SinOsc s2 => dac;
TriOsc t => dac;

volumes => s.gain;
0 => s2.gain;
volumes => t.gain;

for(0 => int i; i < 2; i++) {

  // 1-1
  volumes => s.gain;
  volumes => t.gain;
  F4 => s.freq;
  F3 => t.freq;
  beat => now;

  0 => s.gain;
  0 => t.gain;
  beat => now;

  // 1-2
  volumes => s.gain;
  volumes => t.gain;
  G4 => s.freq;
  B4 => t.freq;
  beat => now;

  0 => s.gain;
  0 => t.gain;
  beat => now;

  // 1-3
  volumes => s.gain;
  volumes => t.gain;
  A4 => s.freq;
  F3 => t.freq;
  beat => now;

  0 => s.gain;
  beat => now;
  
  // 1-4
  volumes => s.gain;
  volumes => t.gain;
  F4 => s.freq;
  F3 => t.freq;
  beat => now;

  0 => s.gain;
  0 => t.gain;
  beat => now;
}

for(0 => int i; i < 2; i++) {
  volumes => s.gain;
  volumes => t.gain;
  A4 => s.freq;
  F3 => t.freq;
  beat => now;
  0 => s.gain;
  0 => t.gain;
  beat => now;
  
  volumes => s.gain;
  volumes => t.gain;
  B4 => s.freq;
  C4 => t.freq;
  beat => now;
  0 => s.gain;
  0 => t.gain;
  beat => now;

  volumes => s.gain;
  volumes => t.gain;
  C4*2 => s.freq;
  F3 => t.freq;
  beat*2 => now;

  0 => s.gain;
  0 => t.gain;
  beat*2 => now;
}

for(0 => int i; i < 2; i++) {
  // 1-1
  volumes => s.gain;
  volumes => t.gain;
  C4*2 => s.freq;
  F3 => t.freq;
  beat/2 => now;

  0 => s.gain;
  beat/2 => now;

  volumes => s.gain;
  D4*2 => s.freq;
  beat/2 => now;

  0 => s.gain;
  0 => t.gain;
  beat/2 => now;
  
  
  // 1-2
  volumes => s.gain;
  volumes => t.gain;
  C4*2 => s.freq;
  C4 => t.freq;
  beat/2 => now;

  0 => s.gain;
  beat/2 => now;

  volumes => s.gain;
  B4 => s.freq;
  beat/2 => now;

  0 => s.gain;
  0 => t.gain;
  beat/2 => now;

  // 1-3
  volumes => s.gain;
  volumes => t.gain;
  A4 => s.freq;
  F3 => t.freq;
  beat => now;
  
  0 => s.gain;
  beat => now;

  // 1-4
  volumes => s.gain;
  F4 => s.freq;
  beat => now;

  0 => s.gain;
  0 => t.gain;
  beat => now;
}

for(0 => int i; i < 2; i++) {
  // 1-1
  volumes => s.gain;
  volumes => s2.gain;
  volumes => t.gain;
  A4 => s.freq;
  F4 => s2.freq;
  F3 => t.freq;
  beat => now;

  0 => s.gain;
  0 => s2.gain;
  0 => t.gain;
  beat => now;

  // 1-2
  volumes => s.gain;
  volumes => t.gain;
  E4 => s.freq;
  C4 => t.freq;
  beat => now;

  0 => s.gain;
  0 => s2.gain;
  0 => t.gain;
  beat => now;

  // 1-3
  volumes => s.gain;
  volumes => s2.gain;
  volumes => t.gain;
  A4 => s.freq;
  F4 => s2.freq;
  F3 => t.freq;
  beat*2 => now;

  0 => s.gain;
  0 => s2.gain;
  0 => t.gain;
  beat*2 => now;
}