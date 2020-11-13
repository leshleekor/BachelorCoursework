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

class BPM {
  dur hN, qN, eN, sN, tN;
  fun void tempo(float beat) {
    60.0/(beat) => float SPB;
    SPB::second => qN;
    qN*2 => hN;
    qN*0.5 => eN;
    eN*0.5 => sN;
    sN*0.5 => tN;
  }
}

BPM bpm;
bpm.tempo(150);
bpm.eN => dur en;
bpm.qN => dur qn;
bpm.hN => dur hn;
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
[
65, 67, 69, 65,  65, 67, 69, 65,  69, 70, 72,  69, 70, 72, 
72, 74, 72, 70, 69, 65, 72, 74, 72, 70, 69, 65, 69, 64, 69, 69, 64, 69
]
@=> int high[];
[
53, 60, 53,  53, 60, 53,  53, 60, 53,  53, 60, 53,
53, 60, 53,  53, 60, 53,  53, 60, 53,  53, 60, 53
]
@=> int low[];
[
qn, qn, hn,  qn, qn, hn,  qn, qn, hn,  qn, qn, hn,
qn, qn, hn,  qn, qn, hn,  qn, qn, hn,  qn, qn, hn
]
@=> dur lowDur[];

Player player;
Mandolin finger => dac;
player.play(finger, melody, melodyDur);
15::second => now;
