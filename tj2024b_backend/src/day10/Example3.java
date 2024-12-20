package day10;

public class Example3 {

	public static void main(String[] args) {
		BoardDTO dto1 = new BoardDTO();
		dto1.setTitle("title1");
		dto1.setContent("content1");
		dto1.setWriter("writer1");
		System.out.println(dto1.toString());
		
		BoardDTO dto2 = new BoardDTO();
		dto2.setTitle("title2");
		dto2.setContent("content2");
		dto2.setWriter("writer2");
		System.out.println(dto2.toString());
		
		BoardDTO dto3 = new BoardDTO();
		dto3.setTitle("title3");
		dto3.setContent("content3");
		dto3.setWriter("writer3");
		System.out.println(dto3.toString());

	}

}
