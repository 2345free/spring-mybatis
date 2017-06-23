package service.server;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import service.demo.Hello;
import service.demo.HelloServiceImpl;

public class HelloServiceServer {
	/**
	 * 启动 Thrift 服务器
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			TProcessor tprocessor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());
			// 阻塞IO
			TServerSocket serverTransport = new TServerSocket(7911);
			//多线程服务模型
			TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
			tArgs.processor(tprocessor);
			//客户端协议要一致
			tArgs.protocolFactory(new TBinaryProtocol.Factory());
			// 线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求。
			TServer server = new TThreadPoolServer(tArgs);
			System.out.println("Start server on port 7911...");
			server.serve(); // 启动服务

		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}