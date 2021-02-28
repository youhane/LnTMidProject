package lntProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
	
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<Karyawan> karyawanList = new ArrayList<Karyawan>();
	Object temp = new ArrayList<Karyawan>();

	public Main() {
			int choose;
			int jumlahKaryawan = 0, manager = 0, supervisor = 0, admin = 0;
				
			do
			{
//				System.out.println("Jumlah karyawan = " + jumlahKaryawan + " Manager = " + manager + " Supervisor = " + supervisor + " Admin = " + admin);
				System.out.println("PT. MENTOL");
				System.out.println("1. Insert data karyawan");
				System.out.println("2. View data karyawan");
				System.out.println("3. Update data karyawan");
				System.out.println("4. Delete data karyawan");
				System.out.println("5. Exit");
				System.out.print("Masukkan nomor dari pilihan diatas: ");
				choose = scan.nextInt(); scan.nextLine();
				switch(choose)
				{
				case 1:
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nInsert");
					String kode1, nama1, gender1, jabatan1;
					Integer gaji1 = 0;
					
					Character a, b;
					Integer c, d, e, f;
					a = (char)(rand.nextInt(25)+'A');
					b = (char)(rand.nextInt(25)+'A');
					c = (rand.nextInt(10));
					d = (rand.nextInt(10));
					e = (rand.nextInt(10));
					f = (rand.nextInt(10));
					
					kode1 = a.toString() + b.toString() + '-' + c.toString() + d.toString() + e.toString() + f.toString();
					
					do 
					{	
						System.out.print("Masukkan nama (Minimal 3 karakter): ");
						nama1 = scan.nextLine();
					} while (nama1.length() < 3);
					
					String male = "Laki-Laki", female = "Perempuan";
					do 
					{
						System.out.print("Jenis Kelamin (Laki-Laki/Perempuan): ");
						gender1 = scan.nextLine();
					} while (!gender1.contentEquals(male) && !gender1.contentEquals(female));
					
					String adm = "Admin", manage = "Manager", superv = "Supervisor";
					do 
					{		
						System.out.print("Masukkan jabatan (Manager/Supervisor/Admin): " );
						jabatan1 = scan.nextLine();
						if(jabatan1.equals(manage))
						{
							gaji1 = 8000000;
							manager++;
						}
						else if(jabatan1.equals(superv))
						{
							gaji1 = 6000000;
							supervisor++;
						}
						else if(jabatan1.equals(adm))
						{
							gaji1 = 4000000;
							admin++;
						}
					} while (!jabatan1.contentEquals(manage) && !jabatan1.contentEquals(superv) && !jabatan1.contentEquals(adm));
					
					karyawanList.add(new Karyawan(kode1, nama1, gender1, jabatan1, gaji1));
					
					if(manager == 4)
					{
						for(int i = jumlahKaryawan-1; i >= 0; i--)
						{
							String currJab = karyawanList.get(i).getJabatan();
							if(currJab.contentEquals(manage))
							{
								Integer takeM = karyawanList.get(i).getGaji();
								Integer bonusM = takeM/10;
								takeM += bonusM;
								karyawanList.get(i).setGaji(takeM);
								manager = 0;
							}
						}
//						3 manager sebelumnya + gaji/10;
					}
					if(supervisor == 4)
					{
						for(int i = jumlahKaryawan-1; i >= 0; i--)
						{
							String currJab = karyawanList.get(i).getJabatan();
							if(currJab.contentEquals(superv))
							{
								Integer takeS = karyawanList.get(i).getGaji();
								Integer bonusS = takeS*75/1000;
								takeS += bonusS;
								karyawanList.get(i).setGaji(takeS);
								supervisor = 0;
							}
						}
//						3 supervisor sebelumnya + 0.075*gaji;
					}
					if(admin == 4)
					{
						for(int i = jumlahKaryawan-1; i >= 0; i--)
						{
							String currJab = karyawanList.get(i).getJabatan();
							if(currJab.contentEquals(adm))
							{
								Integer takeA = karyawanList.get(i).getGaji();
								Integer bonusA = takeA*5/100;
								takeA += bonusA;
								karyawanList.get(i).setGaji(takeA);
								admin = 0;
							}
						}
//						3 supervisor admin + 5%gaji;
					}
					jumlahKaryawan++;
					System.out.println("\n\n\n\n\n\n\n\nKaryawan ke-" + jumlahKaryawan);
					System.out.println("Nama: " + nama1 + ", Gender: " + gender1 + ", Gaji: " + gaji1 + ", Jabatan: " + jabatan1);
					System.out.println("\n\n\n\n\n\n\n\n");
					break;
					
//					view
				case 2:
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nView");
					for (int x=0; x<karyawanList.size(); x++) // bubble sort outer loop
			        {
			            for (int i=0; i < karyawanList.size()-1; i++) {
			                if (karyawanList.get(i).getNama().compareTo(karyawanList.get(i+1).getNama()) > 0)
			                {
			                    temp = karyawanList.get(i);
			                    karyawanList.set(i,karyawanList.get(i+1) );
			                    karyawanList.set(i+1, (Karyawan) temp);
			                }
			            }
			        }
					System.out.println("_________________________________________________________________________________");
					System.out.println("|    No.|             Nama|             Gender|          Jabatan|            Gaji|");
					System.out.println("---------------------------------------------------------------------------------");
					for(int i = 0; i < karyawanList.size(); i++)
					{
						System.out.println("|" + karyawanList.get(i).getKode() + "|           " + karyawanList.get(i).getNama() + "|          " + karyawanList.get(i).getGender() + "|            " + karyawanList.get(i).getJabatan() + "|          " + karyawanList.get(i).getGaji() + "|");
					}
					System.out.println("---------------------------------------------------------------------------------");
					break;
					
//					update
				case 3:
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nUpdate");
					System.out.println("_________________________________________________________________________________");
					System.out.println("|    No.|             Nama|             Gender|          Jabatan|            Gaji|");
					System.out.println("---------------------------------------------------------------------------------");
					for(int i = 0; i < karyawanList.size(); i++)
					{
						System.out.println("|" + karyawanList.get(i).getKode() + "|           " + karyawanList.get(i).getNama() + "|          " + karyawanList.get(i).getGender() + "|            " + karyawanList.get(i).getJabatan() + "|          " + karyawanList.get(i).getGaji() + "|");
					}
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println("Masukkan nama karyawan yang ingin di update");
					String edit = scan.nextLine();
					
					for(int i = 0; i<karyawanList.size(); i++)
					{
						String curr = karyawanList.get(i).getNama();
						if(edit.contentEquals(curr))
						{
							System.out.println("Masukkan data yang baru:");
							System.out.print("Kode: "); String kode = scan.nextLine();
							System.out.print("Nama: "); String nama = scan.nextLine();
							
							String gender, male1 = "Laki-Laki", female1 = "Perempuan";
							do 
							{
								System.out.print("Gender (Laki-Laki/Perempuan): "); 
								gender = scan.nextLine();
							} while (!gender.contentEquals(male1) && !gender.contentEquals(female1));
							
							
							String jabatan, adm1 = "Admin", manage1 = "Manager", superv1 = "Supervisor";
							do
							{
								System.out.print("Jabatan (Manager/Supervisor/Admin): ");
								jabatan = scan.nextLine();
							}while(!jabatan.contentEquals(manage1) && !jabatan.contentEquals(superv1) && !jabatan.contentEquals(adm1));
							
							Integer gaji;
							do
							{
								System.out.print("Gaji (Max. 8000000): "); gaji = scan.nextInt(); scan.nextLine();
							} while(gaji > 8000000);
							
							karyawanList.get(i).setKode(kode);
							karyawanList.get(i).setNama(nama);
							karyawanList.get(i).setGender(gender);
							karyawanList.get(i).setJabatan(jabatan);
							karyawanList.get(i).setGaji(gaji);
						}
					}
					break;
					
//					delete
				case 4:
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nDelete");
					System.out.println("_________________________________________________________________________________");
					System.out.println("|    No.|             Nama|             Gender|          Jabatan|            Gaji|");
					System.out.println("---------------------------------------------------------------------------------");
					for(int i = 0; i < karyawanList.size(); i++)
					{
						System.out.println("|" + karyawanList.get(i).getKode() + "|           " + karyawanList.get(i).getNama() + "|          " + karyawanList.get(i).getGender() + "|            " + karyawanList.get(i).getJabatan() + "|          " + karyawanList.get(i).getGaji() + "|");
					}
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println("Masukkan nama karyawan yang ingin dihapus");
					String apus = scan.nextLine();
					for(int i = 0; i<karyawanList.size(); i++)
					{
						String curr = karyawanList.get(i).getNama();
						if(apus.contentEquals(curr))
						{
							karyawanList.remove(i);
						}
					}
					break;
					
//					exit
				case 5:
					System.out.println("Terima kasih telah menggunakan aplikasi ini.");
					break;
				}
			}while(choose < 5);
	}

	public static void main(String[] args) {
		new Main();

	}

}
