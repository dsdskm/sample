class Shape2 {
  static create(x, y) {
    return new Shape2(x, y);
  }

  name = "Shape2";
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }

  move() {
    return this.x * this.y;
  }
  area() {
    return 0;
  }
}

export default Shape2;
