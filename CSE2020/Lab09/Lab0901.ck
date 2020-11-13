// CSE2020 - Lab09-01
// 2018042797 
// Seunghyeon Lee 

class Player {
  fun void play(StkInstrument inst, int notes[], dur duration[]) {
    for (0=>int i; i < notes.cap(); i++) {
      playNote(inst, notes[i], duration[i]);
    }
  }

  fun void playNote(StkInstrument inst, int note, dur duration) {
    Std.mtof(note) => inst.freq;
    if(note != -1)
      1.0 => inst.noteOn;
      duration => now;
      1.0 => inst.noteOff;
  }
}

0.2::second => dur en; // eighth notes (1/8)
en * 2 => dur qn; // quarter notes (1/4)
qn * 2 => dur hn; // half notes (1/2)

[
65, 67, 69, 65,  65, 67, 69, 65,  69, 70, 72,  69, 70, 72,
72, 74, 72, 70, 69, 65, 72, 74, 72, 70, 69, 65, 65, 60, 65, 65, 60, 65
]
@=> int melody[];
[
qn, qn, qn, qn,  qn, qn, qn, qn, qn, qn, hn,  qn, qn, hn,
en, en, en, en, qn, qn, en, en, en, en, qn, qn, qn, qn, hn, qn, qn, hn
]
@=> dur melodyDur[];

Player player;
Mandolin finger => dac;
player.play(finger, melody, melodyDur);
15::second => now;
