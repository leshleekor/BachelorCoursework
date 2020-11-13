// CSE2020 - Lab09-04
// 2018042797 
// Seunghyeon Lee 

BPM bpm;
Machine.add(me.dir() + "/Lab0904_BPM.ck");
Machine.add(me.dir() + "/Lab0904_Player.ck");
Machine.add(me.dir() + "/Lab0904_score.ck")
bpm.wholeNote * 2 => now;
Machine.add(me.dir() + "/Lab0904_score.ck");