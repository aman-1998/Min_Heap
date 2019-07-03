import java.util.*;
import java.lang.*;
class prac2
{
	int heap_size,min;
	int[] build_heap(int[] H)
	{
		int i;
		for(i=heap_size/2;i>=1;i--)
			H=min_heapify(H,i);
		return H;
	}
	int[] min_heapify(int[] H,int i)
	{
		int l,r,smallest,temp;
		l=2*i;
		r=2*i+1;
		if(l<=heap_size && H[l]<H[i])
			smallest=l;
		else
			smallest=i;
		if(r<=heap_size && H[r]<H[smallest])
			smallest=r;
		if(smallest!=i)
		{
			temp=H[i];
			H[i]=H[smallest];
			H[smallest]=temp;
			H=min_heapify(H,smallest);
		}
		return H;
	}
	int[] decreasing_order(int[] H)
	{
		int min;
		while(heap_size!=1)
		{
			min=H[1];
			H[1]=H[heap_size];
			H[heap_size]=min;
			heap_size--;
			min_heapify(H,1);
		}
		return H;
	}
	int[] delete_min(int[] H)
	{
		min=H[1];
		H[1]=H[heap_size];
		heap_size--;
		min_heapify(H,1);
		return H;
	}
	int[] increase_key(int[] H,int key,int i)
	{
		if(key<=H[i] || i<1 || i>heap_size)
		{
			System.out.println("\nInvalid Input");
			return H;
		}
		H[i]=key;
		H=min_heapify(H,i);
		return H;
	}
	int[] decrease_key(int[] H,int key,int i)
	{
		int temp;
		if(key>=H[i] || i<1 || i>heap_size)
		{
			System.out.println("\nInvalid Input");
			return H;
		}
		H[i]=key;
		while(i>1 && H[i]<H[i/2])
		{
			temp=H[i];
			H[i]=H[i/2];
			H[i/2]=temp;
			i=i/2;
		}
		return H;
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n,i,ch,key;
		System.out.print("Enter the size of heap: ");
		n=in.nextInt();
		prac2 ob=new prac2();
		ob.heap_size=n;
		int[] H=new int[n+1];
		for(i=1;i<=n;i++)
		{
			System.out.print("Enter H["+i+"] ");
			H[i]=in.nextInt();
		}
		System.out.print("Input Array: ");
		for(i=1;i<=n;i++)
			System.out.print(H[i]+" ");
		H=ob.build_heap(H);
		System.out.print("\nMin Heap: ");
		for(i=1;i<=ob.heap_size;i++)
			System.out.print(H[i]+" ");
		while(true)
		{
			System.out.print("\n1.Decreasing order\n2.Delete Min\n3.Increase Key\n4.Decrease Key\n5.Exit\n");
			System.out.print("\nEnter your choice: ");
			ch=in.nextInt();
			switch(ch)
			{
				case 1:
					H=ob.decreasing_order(H);
					System.out.print("Decreasing order: ");
					for(i=1;i<=ob.heap_size;i++)
						System.out.print(H[i]+" ");
					System.exit(0);
				case 2:
					System.out.println("Min = "+ob.min);
					System.out.print("\nMin Heap: ");
					for(i=1;i<=ob.heap_size;i++)
						System.out.print(H[i]+" ");
					System.exit(0);
				case 3:
					System.out.print("Enter the key and index: ");
					key=in.nextInt();
					i=in.nextInt();
					H=ob.increase_key(H,key,i);
					System.out.print("\nMin Heap: ");
					for(i=1;i<=ob.heap_size;i++)
						System.out.print(H[i]+" ");
					System.exit(0);
				case 4:
					System.out.print("Enter the key and index: ");
					key=in.nextInt();
					i=in.nextInt();
					H=ob.decrease_key(H,key,i);
					System.out.print("\nMin Heap: ");
					for(i=1;i<=ob.heap_size;i++)
						System.out.print(H[i]+" ");
					System.exit(0);
				case 5:
					System.out.print("\nInvalid Input\n");
					break;
			}
		}
	}
}