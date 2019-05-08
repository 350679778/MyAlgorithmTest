package tree.huffman.code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHuffmanCode {

	public static void main(String[] args) {
//		String msg = "can you can a can as a can canner can a can.";
//		byte[] bytes = msg.getBytes();
		
		//���кշ�������
//		byte[] b = huffmanZip(bytes);
//		System.out.println(bytes.length);
//		System.out.println(b.length);
		//ʹ�úշ���������н���
//		byte[] newBytes = decode(huffCodes,b);
//		System.out.println(Arrays.toString(bytes));
//		System.out.println(Arrays.toString(newBytes));
		
		
//		System.out.println(new String(newBytes));
		
//		String src = "2.bmp";
//		String dst = "3.zip";
//		try {
//			zipFile(src,dst);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String src = "3.zip";
		String dst = "4.bmp";
		try {
			unZip(src,dst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �ļ��Ľ�ѹ
	 * @param src
	 * @param dst
	 */
	public static void unZip(String src,String dst) throws Exception{
		//����һ��������
		InputStream is = new FileInputStream(src);
		ObjectInputStream ois = new ObjectInputStream(is);
		//��ȡbyte����
		byte[] b = (byte[])ois.readObject();
		//��ȡ�շ��������
		Map<Byte,String> codes = (Map<Byte,String>)ois.readObject();
		System.out.println(codes);
		ois.close();
		is.close();
		//����
		byte[] bytes = decode(codes,b);
		//����һ������� 
		OutputStream os = new FileOutputStream(dst);
		//д������
		os.write(bytes);
		os.close();
	}
	
	
	/**
	 * ѹ���ļ�
	 * @param src
	 * @param dst
	 * @throws IOException
	 */
	public static void zipFile(String src,String dst) throws IOException{
		//����һ��������
		InputStream is = new FileInputStream(src);
		//����һ����������ָ����ļ���Сһ����byte����
		byte[] b = new byte[is.available()];
		//��ȡ�ļ�����
		is.read(b);
		is.close();
		//ʹ�úշ���������б���
		byte[] byteZip = huffmanZip(b);
		//�����
		OutputStream os = new FileOutputStream(dst);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		//��ѹ�����byte����д���ļ�
		oos.writeObject(byteZip);
		//�Ѻշ��������д���ļ�
		oos.writeObject(huffCodes);
		oos.close();
		os.close();
		
	}
	
	/**
	 * ʹ��ָ���ĺշ����������н���
	 * @param huffCodes2
	 * @param b
	 * @return
	 */
	private static byte[] decode(Map<Byte, String> huffCodes2, byte[] bytes) {
		System.out.println("����---------------");
		StringBuilder sb = new StringBuilder();
		//��byte����תΪһ�������Ƶ��ַ���
		for (int i=0;i < bytes.length;i++) {
			byte b = bytes[i];
			//�Ƿ������һ��
			boolean flag = (i == bytes.length-1);
			sb.append(byteToBitStr(!flag,b));
		}
//		System.out.println(sb.toString());
		//���ַ�������ָ���ĺշ���������н���
		//�Ѻշ�������ļ�ֵ�Խ��е���
		Map<String,Byte> map = new HashMap<String,Byte>();
		for(Map.Entry<Byte, String> entry : huffCodes.entrySet()){
			map.put(entry.getValue(), entry.getKey());
		}
		//����һ�����ϣ����ڴ�byte
		List<Byte> list = new ArrayList<>();
		//�����ַ���
		for(int i=0;i<sb.length();){
			int count = 1;
			boolean flag = true;
			Byte b = null;
			//��ȡ��һ��byte
			while(flag){
				String key = "";
				if(i+count<sb.length()){
					key = sb.substring(i,i+count);
				}else{
					key = sb.substring(i);
				}
				b = map.get(key);
				if(b == null){
					count++;
				}else{
					flag = false;
				}
			}
			list.add(b);
			i+=count;
		}
		//�Ѽ���תΪ����
		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;
	}

	private static String byteToBitStr(boolean flag,byte b){
		int temp = b;
		if(flag)
			temp|=256;
		String str = Integer.toBinaryString(temp);
		if(flag)
			return str.substring(str.length()-8);
		return str;
	}
	
	

	/**
	 * ���кշ�������ѹ���ķ���
	 * @param bytes
	 * @return
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		//��ͳ��ÿһ��byte���ֵĴ�����������һ��������
		List<Node> nodes = getNodes(bytes);
//		System.out.println(nodes.toString());
		//����һ�źշ�����
		Node tree = createHuffmanTree(nodes);
//		System.out.println(tree);
//		System.out.println(tree.left);
//		System.out.println(tree.right);
		//����һ���շ��������
		Map<Byte,String> huffCodes = getCodes(tree);
//		System.out.println(huffCodes);
		//����
		byte[] b = zip(bytes,huffCodes);
		return b;
	}

	/**
	 * ���кշ�������
	 * @param bytes
	 * @param huffCodes2
	 * @return
	 */
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes2) {
		StringBuilder sb = new StringBuilder();
		//����Ҫѹ����byute���鴦��ɶ����Ƶ��ַ���
		for (byte b : bytes) {
			sb.append(huffCodes.get(b));
		}
		
		System.out.println(sb.toString());
		//���峤��
		int len;
		if(sb.length()%8 == 0){
			len = sb.length()/8;
		}else{
			len = sb.length()/8+1;
		}
		//���ڴ洢ѹ�����byte
		byte[] by = new byte[len];
		int index = 0;
		for (int i = 0; i < sb.length(); i+=8) {
			String strByte;
			if(i+8>sb.length()){
				strByte = sb.substring(i);
			}else{
				strByte = sb.substring(i,i+8);
			}
			byte byt = (byte)Integer.parseInt(strByte,2);
			by[index] = byt;
			index++;
//			System.out.println(strByte+":"+byt);
		}
		return by;
	}

	//������ʱ�洢·��
	static StringBuilder sb = new StringBuilder();
	//���ڴ洢�շ�������
	static Map<Byte,String> huffCodes = new HashMap<>();
	/**
	 * ���ݺշ�������ȡ�շ�������
	 * @param tree
	 * @return
	 */
	private static Map<Byte, String> getCodes(Node tree) {
		//
		if(null == tree){
			return null;
		}
		getCodes(tree.left,"0",sb);
		getCodes(tree.right,"1",sb);
		return huffCodes;
	}


	private static void getCodes(Node node, String code, StringBuilder sb) {
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(code);
		if(null == node.data){
			getCodes(node.left,"0",sb2);
			getCodes(node.right,"1",sb2);
		}else{
			huffCodes.put(node.data, sb2.toString());
		}
	}


	/**
	 * �����շ�����
	 * @param nodes
	 * @return
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size()>1){
			//����
			Collections.sort(nodes);
			//ȡ������Ȩֵ��͵Ķ�����
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			//����һ���µĶ�����
			Node parent = new Node(null,left.weight+right.weight);
			//��֮ǰȡ���������Ŷ�����ɾ��
			parent.left = left;
			parent.right = right;
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}


	/**
	 * ��byte����תΪnode����
	 * @param bytes
	 * @return
	 */
	private static List<Node> getNodes(byte[] bytes) {
		List<Node> nodes = new ArrayList<>();
		//�洢ÿһ��byte�����˶��ٴ�
		Map<Byte,Integer> counts = new HashMap<>();
		//ͳ��ÿһ��byte���ֵĴ���
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if(null == count){
				counts.put(b, 1);
			}else{
				counts.put(b,count+1);
			}
		}
		//��ÿһ����ֵ��תΪһ��node����
		for (Map.Entry<Byte,Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}
}
