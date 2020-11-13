// CSE2020 - Lab09-05
// 2018042797 
// Seunghyeon Lee 

public class MyClarinet extends Clarinet {
  fun float noteOn(int note, float volume) {
    note => Std.mtof => this.freq;
    volume => this.noteOn;
  }
  fun float noteOn(float note, float volume) {
    note => this.freq;
    volume => this.noteOn;
  }
  fun float noteOn(string note, int ocatve, float volume) {
    if(note == "c") {
      Std.mtof(12 + (12*ocatve)) => this.freq;
    } else if(note == "cs") {
      Std.mtof(13 + (12*ocatve)) => this.freq;
    } else if(note == "d") {
      Std.mtof(14 + (12*ocatve)) => this.freq;
    } else if(note == "ep") {
      Std.mtof(15 + (12*ocatve)) => this.freq;
    } else if(note == "e") {
      Std.mtof(16 + (12*ocatve)) => this.freq;
    } else if(note == "f") {
      Std.mtof(17 + (12*ocatve)) => this.freq;
    } else if(note == "fs") {
      Std.mtof(18 + (12*ocatve)) => this.freq;
    } else if(note == "g") {
      Std.mtof(19 + (12*ocatve)) => this.freq;
    } else if(note == "ap") {
      Std.mtof(20 + (12*ocatve)) => this.freq;
    } else if(note == "a") {
      Std.mtof(21 + (12*ocatve)) => this.freq;
    } else if(note == "bp") {
      Std.mtof(22 + (12*ocatve)) => this.freq;
    } else if(note == "b") {
      Std.mtof(23 + (12*ocatve)) => this.freq;
    } 
  }
}

MyClarinet c => dac;

c.noteOn(1.0);
1::second => now;

c.noteOn(60, 1.0);
1::second => now;

c.noteOn("b", 4,  1.0);
1::second => now;

c.noteOn("bp", 4,  1.0);
1::second => now;
