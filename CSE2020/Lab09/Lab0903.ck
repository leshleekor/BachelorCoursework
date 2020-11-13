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
  dur wN, hN, qN, eN, sN, tN;
  dur sixN, thrN;
  fun void tempo(float beat) {
    60.0/(beat) => float SPB;
    SPB::second => qN;
    qN*2 => hN;
    hN*2 => wN;
    qN*0.5 => eN;
    eN*0.5 => sN;
    sN*0.5 => tN;
    qN/3 => thrN;
    eN/3 => sixN;
  }
}

BPM bpm;
bpm.tempo(200);
bpm.eN => dur sn;
bpm.qN => dur tn;
bpm.hN => dur hn;
bpm.wN => dur wn;

[
60, 60, 60, 62, 64,
64, 62, 64, 65, 67,
72, 72, 72, 67, 67, 67, 64, 64, 64, 60, 60, 60,
67, 65, 64, 62, 60
]
@=> int melody[];

[
hn, hn, tn, sn, hn, 
tn, sn, tn, sn, wn,
sn, sn, sn, sn, sn, sn, sn, sn, sn, sn, sn, sn,
tn, sn, tn, sn, wn
]
@=> dur melodyDur[];


Mandolin finger;
Player player;
finger => dac;
spork ~ player.play(finger, melody, melodyDur);
wn * 2 => now;
spork ~ player.play(finger, melody, melodyDur);
wn * 2 => now;
spork ~ player.play(finger, melody, melodyDur);
wn * 2 => now;
spork ~ player.play(finger, melody, melodyDur);
wn * 8 => now;