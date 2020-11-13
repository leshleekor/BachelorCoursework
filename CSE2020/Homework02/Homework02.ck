SinOsc s => Pan2 ps => dac;
TriOsc t => Pan2 pt => dac;
TriOsc q => Pan2 pq => dac;
SinOsc w => Pan2 pw => dac;

1::second => dur quarter_note;
quarter_note * (5.0/6) => dur qn; 
quarter_note / 6 => dur qn_rest; 

0.03 => float on;
0.0 => float off;

Math.srandom(10);
for(0 => int i; i <=32; i++) {
  Math.random2(60, 71) => int r;
  Math.random2(1, 5) => int code;
  
  // Pan
  (-1^i) => ps.pan;
  -0.3*(-1^i) => pt.pan;
  0.3*(-1^(i+1)) => pq.pan;
  (-1^(i+1)) => pw.pan;
  
  if(code == 1) { 
    // Major Code
    Std.mtof(r) => s.freq;
    Std.mtof(r+4) => t.freq;
    Std.mtof(r+7) => q.freq;
    off => w.gain;
  }
  else if(code == 2) { 
    // Minor Code
    Std.mtof(r) => s.freq;
    Std.mtof(r+3) => t.freq;
    Std.mtof(r+7) => q.freq;
    off => w.gain;
  }
  else if(code == 3) { 
    // dim Code
    Std.mtof(r) => s.freq;
    Std.mtof(r+3) => t.freq;
    Std.mtof(r+6) => q.freq;
    off => w.gain;
  }
  else if(code == 4) { 
    // M7 Code
    Std.mtof(r) => s.freq;
    Std.mtof(r+4) => t.freq;
    Std.mtof(r+7) => q.freq;
    Std.mtof(r+11) => w.freq;
    on => w.gain;
  }
  else if(code == 5) { 
    // m7 Code
    Std.mtof(r) => s.freq;
    Std.mtof(r+3) => t.freq;
    Std.mtof(r+7) => q.freq;
    Std.mtof(r+10) => w.freq;
    on => w.gain;
  }
    on => s.gain;
    on => t.gain;
    on => q.gain;
    qn => now;
    off => s.gain;
    off => t.gain;
    off => q.gain;
    qn_rest => now;
}
