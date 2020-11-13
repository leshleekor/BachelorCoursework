SinOsc s => dac;
BPM t;
t.tempo(300);
0.3 => s.gain;

400 => int freq;
while(freq<800) {
  freq => s.freq;
  t.qN => now;
  50 +=> freq;
}