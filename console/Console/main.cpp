#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <climits>
#include "struct.h"
// formatting : Ctrl + K + D

#define SIZE 20
using namespace std;

void section1();
inline float square(float x) { return x * x; }
template <class Any>
Any sum(Any, Any);


int main() {
	// friend



	return 0;
}



template <class Any>
Any sum(Any a, Any b) {
	return a + b;
}

void section1() {
	// variable
	short n_short = SHRT_MAX;
	int n_int = INT_MAX;
	long n_long = LONG_MAX;
	long long n_llong = LLONG_MAX;

	unsigned short unsigned_short = 1;
	unsigned int unsigned_int = 1;
	unsigned long unsigned_long = 1;
	unsigned long long unsigned_llong = 1;

	// constant
	const float PI = 3.14;

	// cast
	int a = 3.141592;
	char ch = 'M';
	cout << static_cast<int>(ch) << endl;
	cout << int(ch) << endl;

	// auto
	auto n = 100;
}

void section2() {
	// struct
	struct MyStruct
	{
		string name;
		string position;
		float height;
		float weight;
	} B;

	MyStruct A;
	A.name = "Son";
	A.position = "Striker";
	A.height = 183;
	A.weight = 77;

	//cout << A.name << endl;

	B = {
		"Lee","Mid",175,70
	};
	cout << B.height << endl;

	// union
	union MyUnion
	{
		int intVal;
		long longVal;
		float floatVal;
	};

	MyUnion test;
	test.intVal = 5;
	test.longVal = 5;
	test.floatVal = 5.5;

	// enum
	enum spectrum { red, orange, yellow, green, blue, violet, indogo, ultraviolet };
	spectrum a = orange;
	cout << a << endl;
}

void section3() {
	// delete
	/*
	* 1. new�� ������ ��츸 delete�� ����
	* 2. ���� �޸� ����� ���޾� �� �� delete �Ұ�
	* 3. new[]�� �޸𸮸� ������ ��� delete[]�� ����
	*/
	int* pointer = new int;
	delete pointer;

	double* p3 = new double[3];
	p3[0] = 0.2;
	p3[1] = 0.5;
	p3[2] = 0.8;

	cout << "p3[1] is " << p3[1] << endl;

	p3 = p3 + 1;
	cout << "Now p3[0] is " << p3[0] << endl;
	cout << "Now p3[1] is " << p3[1] << endl;

	p3 = p3 - 1;
	delete[] p3;


	char animal[SIZE];
	char* ps;

	cout << "���� �̸��� �Է��Ͻÿ�\n";
	cin >> animal;
	ps = new char[strlen(animal) + 1];
	strcpy(ps, animal);

	cout << "�Է��Ͻ� ���� �̸��� �����Ͽ����ϴ�." << endl;
	cout << "�Է��Ͻ� ���� �̸��� " << animal << "�̰�, �� �ּҴ� " << (int*)animal << " �Դϴ�." << endl;
	cout << "����� ���� �̸��� " << ps << "�̰�, �� �ּҴ� " << (int*)ps << " �Դϴ�." << endl;
}

void section7() {
	MyStruct PandaCoding = {
		"Panda",26
	};

	display(PandaCoding);
}