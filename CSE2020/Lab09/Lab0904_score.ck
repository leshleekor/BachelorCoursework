BPM bpm;
bpm.tempo(200.0);
bpm.sixthNote => dur sn;
bpm.thirdNote => dur tn;
bpm.halfNote => dur hn;
bpm.wholeNote => dur wn;

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

Wurley player => dac;
Player p;
p.play(player, melody, melodyDur);