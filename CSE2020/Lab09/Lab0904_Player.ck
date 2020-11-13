// CSE2020 - Lab09-04
// 2018042797 
// Seunghyeon Lee 

public class Player {
  fun void play(StkInstrument instrument, int notes[], dur durs[]) {
      for (0 => int i; i < notes.cap(); i++) {
          playNote(instrument, notes[i], durs[i]);
      }
  }

  fun void playNote(StkInstrument instrument, int note, dur duration) {
      Std.mtof(note) => instrument.freq;
      if (note != -1)
          1.0 => instrument.noteOn;
      duration => now;
      1.0 => instrument.noteOff;
  }
}