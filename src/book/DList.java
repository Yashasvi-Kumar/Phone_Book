package book;
import java.util.*;

public class DList {
	DNode temp,ptr,ptr1,ptr2,dup;
	static DNode head=null;
	public DList(){
		this.temp=null;
		this.ptr=null;
		this.ptr1=null;
		this.ptr2=null;
		this.dup=null;
	}
	
	private void accept() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		char ans = sc.next().charAt(0);
		sc.nextLine();
		do {
			System.out.println("\nEnter name");
			String name=sc.nextLine();
			
			System.out.println("\n Enter Number");
			int num=sc.nextInt();
			sc.nextLine();
			
			while(Integer.toString(num).length()!=10) {
				System.out.println("Enter Number");
				num=sc.nextInt();
				sc.nextLine();
			}
			
			System.out.println("\nEnter Gmail");
			String gmail=sc.nextLine();
			sc.nextLine();
			
			temp=new DNode(num,name,gmail);
			
			if(head==null) {
				head=temp;
			}
			else {
				ptr=head;
				while(ptr.next!=null) {
					ptr=ptr.next;
				}
				ptr.next=temp;
				temp.prev=ptr;
			}
			
			System.out.println("Do you want to continue");
			ans=sc.next().charAt(0);
			sc.nextLine();
			
		}while(ans=='y');
	}
	
	private void delete(String name) {
		int c=0;
		ptr=head;
		while(ptr!=null) {
			if(ptr.name.equals(name)) {
				c=1;
				break;
			}
			else {
				c=2;
			}
			ptr=ptr.next;
		}
		if(c==1 && ptr!=head && ptr.next!=null) {
			ptr.prev.next=ptr.next;
			ptr.next.prev=ptr.prev;
			System.out.println("Account is successfully deleted");
		}
		
		if(c==1 && ptr==head) {
			head=head.next;
			head.prev=null;
			System.out.println("Account is successfully deleted");
		}
		if(c==1 && ptr.next==null) {
			ptr.prev.next=null;
			ptr.prev=null;
			System.out.println("Account is successfully deleted");
		}
		if(c==2) {
			System.out.println("Sorry! The value is not in the list");
		}
	}
	
	private void update(String name) {
		System.out.println(name);
		Scanner sc=new Scanner(System.in);
		ptr=head;
		char ans;
		while(ptr!=null) {
			if(ptr.name.equals(name)) {
				
				do {
					System.out.println("what do you want to update?\n 1) Name \n2) Number\n3)Gmail ");
					int c=sc.nextInt();
					sc.nextLine();
					switch(c) {
						case 1:
							System.out.println("\nEnter new name");
							ptr.name=sc.nextLine();
							//System.out.println(ptr.name);
							sc.nextLine();
							break;
						
						case 2:
							System.out.println("\nEnter new number");
							ptr.num=sc.nextInt();
							sc.nextLine();
							while(Integer.toString(ptr.num).length()!=10) {
								System.out.println("Enter Number");
								ptr.num=sc.nextInt();
								sc.nextLine();
							}
							break;
						case 3:
							System.out.println("\nEnter new gmail");
							ptr.gmail=sc.nextLine();
							sc.nextLine();
							break;
					}
					
					System.out.println("Do you want to continue?");
					ans=sc.next().charAt(0);
				}while(ans=='y');
				
			}
			
			ptr=ptr.next;
		}
	}
	
	private void seachByName(String name) {
		ptr=head;
		while(ptr!=null) {
			if(ptr.name.equals(name)) {
				System.out.println("Searched contact found and the details are:\n");
				System.out.println(ptr.name);
				System.out.println(ptr.num);
				System.out.println(ptr.gmail);
			}
			ptr=ptr.next;
		}
	}
	private void seachByNumber(int num) {
		ptr=head;
		while(ptr!=null) {
			if(ptr.num==num) {
				System.out.println("Searched contact found and the details are:\n");
				System.out.println(ptr.name);
				System.out.println(ptr.num);
				System.out.println(ptr.gmail);
			}
			ptr=ptr.next;
		}
	}
	private void seachByGmail(String gmail) {
		ptr=head;
		while(ptr!=null) {
			if(ptr.gmail.equals(gmail)) {
				System.out.println("Searched contact found and the details are:\n");
				System.out.println(ptr.name);
				System.out.println(ptr.num);
				System.out.println(ptr.gmail);
			}
			ptr=ptr.next;
		}
	}
	private void display() {
		ptr=head;
		while(ptr!=null) {
			System.out.println(ptr.num);
			System.out.println(ptr.name);
			System.out.println(ptr.gmail);
			ptr=ptr.next;
		}
	}
	
	private void insert() {
		accept();
	}

	public static void main(String[] args) {
		DList dlist=new DList();
		System.out.println("**************                                PHONE BOOK                          ********************");
		Scanner sc=new Scanner(System.in);
		System.out.println("\nWHAT IS YOUR NAME?");
		String name=sc.nextLine();
		System.out.println("\n\n!!!!!!!!!!!!!!!!!!!!!!!   WELCOME " +name+ "   !!!!!!!!!!!!!!!!!!!!!\n");
		System.out.println("\n\nLet's create our phonebook "+name);
		
		dlist.accept();
		dlist.display();
		System.out.println("What name do you want to search");
		String n=sc.nextLine();
		sc.nextLine();
		dlist.seachByName(n);
		System.out.println("What number do you want to search");
		int number=sc.nextInt();
		sc.nextLine();
		dlist.seachByNumber(number);
		//System.out.println("\nEnter the name whose value you want to update");
		//String n=sc.nextLine();
		//sc.nextLine();
		//dlist.update(n);
		//dlist.display();
		//System.out.println("Enter the value you want to delete");
		//String n1=sc.nextLine();
		//sc.nextLine();
		//dlist.delete(n1);
		//dlist.display();
	}

	

}
