#include <iostream>
#include <iomanip>
#include <fstream>
#include <cstring>

using namespace std;

class Customer
{
    protected :
        int id;
        string name;
        int age;
        string password;
        static int count;
    public :
        Customer():id(count++),name("n/a"), age(0),password("n/a"){}
        Customer(string a, int b, string c):id(count++),name(a), age(b), password(c){}
        ~Customer(){}

        string getname(){return name;}
        int getage(){return age;}
        string getpassword(){return password;}
        static int getcount(){return count;}

        void readdata()
        {
            cout<<"Enter name: ";
            cin>>name;
            cout<<"Enter age: ";
            cin>>age;
            cout<<"Enter password: ";
            cin>>password;
        }

        void showdata()
        {
            cout<<id<<" "<<name<<" "<<age<<endl;
        }
};

class Worker : public Customer
{
    private :
        int worker_id;
        int a;
        static int c,d;
    public :
        Worker(): Customer(), worker_id(c++),a(d++){}
        Worker(string a, int b, string e, int c): Customer(a,b,e), worker_id(c++),a(d++){}
        ~Worker(){}

        int getworker_id(){return worker_id;}

        void readdata()
        {
            cout<<"Enter worker name: ";
            cin>>name;
            cout<<"Enter worker age: ";
            cin>>age;
        }

        void showdata()
        {
            cout<<a<<"\t"<<"Worker ID: "<<worker_id<<endl<<"\t"<<"Name: "<<name<<endl<<"\t"<<"Age: "<<age<<endl<<endl;
        }
};

class Product
{
private:
	string name;
	double price;
	int quantity;
public:
	Product(): name("n/a"),price(0.0), quantity(0) {}
	Product(string a,double b,int c):name(a),price(b), quantity(c) {}
	~Product() {}

	string getname() { return name;}
	double getprice() {return price;}
	int getquantity() {return quantity;}

	void display(){
		cout<<name<<" "<<price<<endl ;
	}

	void sell_product(int t);
};

void Product :: sell_product(int b)
{
    if(quantity>=b){
        quantity-=b;
    }
}

double calculate_price(Product abc[], int a, int index)
{
    double c;
    c=(abc[index].getprice()*a*.15)+(abc[index].getprice()*a);
    return c;
}

double discount_price(Product abc[], int a, int index)
{
    double c;
    c=(abc[index].getprice()*a)-(abc[index].getprice()*a*0.10);
    return c;
}

int find_product(Product abc[], string a)
{
    int index;
    int i;
    bool flag=false;
    for(i=0;i<5;i++){
                if(abc[i].getname().compare(a)==0){
                    flag=true;
                    index=i;
                    break;
                }
            }
            if(flag==true)
            return index;
            else
                return 1;
}

int find_regester(Customer abc[], string a,string b)
{
    int i;
    bool flag=false;
    int index;
    for(i=0;i<5;i++){
                if(abc[i].getname().compare(a)==0 && abc[i].getpassword().compare(b)==0){
                    flag=true;
                    index=i;
                    break;
                }
            }
            if(flag==true)
                return index;
            else
                return 2;
}

int find_worker(Worker abc[], string a)
{
    int i;
    bool flag=false;
    for(i=0;i<100;i++){
                if(abc[i].getname().compare(a)==0){
                    flag=true;
                    break;
                }
            }
            if(flag==true)
                return 1;
            else{
                return 2;
            }
}

void show_product(Product *abc)
{
    int i;
    cout<<left<<setw(10)<<"Product Name"<<right<<setw(10)<<"Quantity"<<endl;
    for(i=0;i<5;i++)
    cout<<left<<setw(10)<<(abc+i)->getname()<<right<<setw(10)<<(abc+i)->getquantity()<<endl;
}

int Customer :: count=1;
int Worker :: c=101;
int Worker :: d=1;

int main()
{
    int n,x=0,y=0,i,b,index;
    string m,p,nm,a,nam,ps,str;
    char ch,c,cho,choice,chss,chs,d,e;
	double pr,pri,price[100],sum,grand;
	ofstream out;

    Product abc[5]={{"Burger",40.00,100},{"Shampoo",150.00,100},{"Oil",60.50,100},{"Paste",50.00,100},{"Chips",20.00,100}} ;
    Customer c1[100];
    Worker *w1[100];

    while(1)
    {
        sum=0;

        cout<<"---------------------------------------------------------------------"<<endl;
        cout<<"Press 1 for joining as a worker"<<endl;
        cout<<"Press 2 for seeing worker info"<<endl;
        cout<<"Press 3 for regestering as a customer"<<endl;
        cout<<"Press 4 for login"<<endl;
        cout<<"Press 5 for buying product without registration"<<endl;
        cout<<"Press 6 for seeing product quantity"<<endl;
        cout<<"Press 7 for printing the cash with the comment"<<endl;
        cout<<"---------------------------------------------------------------------"<<endl<<endl;

        cout<<"Enter the option: ";
        cin>>n;

        if(n==1){
                while(1){
                    w1[x]=new Worker();
                    w1[x]->readdata();

                    cout<<"Do you want to regester again?(y/n): ";
                    cin>>m;

                    if(m=="n")
                        break;
                    x++;
                }
        }
        else if(n==2){
            for(i=0;i<=x;i++)
            w1[i]->showdata();
        }

        else if(n==3){
            while(1){
                    //c1[y]=new Worker();
                    c1[y].readdata();

                    price[y]=0;

                    cout<<"Do you want to regester again?(y/n): ";
                    cin>>p;

                    if(p=="n")
                        break;
                    y++;
                }
        }
        else if(n==4){
                cout<<"Enter your name: ";
                cin>>nm;
                cout<<"Enter your password: ";
                cin>>ps;
                int p=find_regester(c1,nm,ps);
                if(p==2)
                        cout<<"You are not regesterd."<<endl;
                else{
                        cout<<"Yes. You are regeterd. Want to buy some product?(y/n) :";
                        cin>>cho;
                        if(cho=='y'){

                            while(1){
                                cout<<"Enter the product name: ";
                                cin>>a;
                                index=find_product(abc,a);
                                    if(index==1){
                                        cout<<"Not Availabe.Do you want to continue?(y/n): "<<endl ;
                                        cin>>choice;
                                        if(choice== 'n')
                                            break;
                                    }
                                    else{
                                        cout<<"Yes. It is available here. Enter the quantity: ";
                                        cin>>b;
                                        abc[index].sell_product(b);
                                        pri = discount_price(abc, b, index);
                                        sum+=pri;
                                        price[p]=sum;
                                        cout<<"Price is "<<pri<<endl;
                                        cout<<"Do you want to continue?(y/n): ";
                                        cin>>choice;
                                        if(choice== 'n')
                                            break;
                                    }
                            }
                        }
                    }
        }
        else if(n==5){
            while(1){
                cout<<"Enter the product name: ";
                cin>>a;
                index=find_product(abc,a);
                if(index==1){
                    cout<<"Not Availabe. Do you want to try again?(y/n)";
                    cin>>chs;
                    if(chs=='n')
                        break;
                }
                else{
                    cout<<"Yes. It is available here. Enter the quantity: ";
                    cin>>b;
                    pr = calculate_price(abc, b, index);
                    cout<<"Price is "<<pr<<endl;
                    cout<<"Do you want to try again?(y/n)";
                    cin>>chss;
                    if(chss=='n')
                        break;
                }
            }
        }

        else if(n==6){
            cout<<"Enter worker name: ";
            cin>>nam;
            int q=find_worker(*w1,nam);
            if(q == 1)
                show_product(abc);
            else
                cout<<"You can't see it"<<endl;
        }

        else if(n==7){
                grand=0;
                cout<<left<<setw(15)<<"Name"<<right<<setw(20)<<"Total Amount"<<endl;
            for(i=0;i<=y;i++){
                cout<<left<<setw(15)<<c1[i].getname()<<right<<setw(20)<<price[i]<<endl;
            }
                for(i=0;i<=y;i++){
                    grand+=price[i];
                }

                for(i=0;i<40;i++)
                cout<<"-";
                cout<<endl;
                cout<<left<<setw(15)<<"Grand total: "<<right<<setw(20)<<grand<<endl;

                cout<<"Do you want to generate this?(y/n): ";
                cin>>d;
                if(d=='y'){
                        grand=0;
                    out.open("Selling Info.txt");
                    while(getline(cin,str)){
                            out<<left<<setw(15)<<"Name"<<left<<setw(20)<<"Total Amount"<<endl;
                            for(i=0;i<=y;i++){
                                out<<left<<setw(15)<<c1[i].getname()<<right<<setw(20)<<price[i]<<endl;
                            }
                            for(i=0;i<=y;i++){
                                grand+=price[i];
                            }

                            for(i=0;i<40;i++)
                                out<<"-";
                                out<<endl;
                                out<<left<<setw(15)<<"Grand total: "<<right<<setw(20)<<grand<<endl;
                                out.close();
                                break;
                }
            }
        }
    }
    return 0;
}
