#include "struct.h"
#include "time.h"

void display(MyStruct& temp) {
	cout << "ÀÌ¸§ : " << temp.name << endl;
}

NewTime::NewTime() : Time() {
	day = 0;
};