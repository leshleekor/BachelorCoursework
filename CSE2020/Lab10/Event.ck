fun void foo(Event e, int n, string s) {
  Impulse imp => dac;
  while(true) {
    e => now;
    <<< s, now/second >>>;
    n => imp.next;
  }
}

Event e;
spork ~ foo(e, 3, "A");
spork ~ foo(e, 6, "B");
spork ~ foo(e, 10, "C");

while(true) {
  e.signal();
  1::second => now;
}