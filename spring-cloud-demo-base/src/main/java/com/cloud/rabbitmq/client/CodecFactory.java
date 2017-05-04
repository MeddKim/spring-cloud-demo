package com.cloud.rabbitmq.client;

import java.io.IOException;

/**
 * 编码和解码工厂
 */
public interface CodecFactory {

	byte[] serialize(Object obj) throws IOException;
	
	Object deSerialize(byte[] in) throws IOException;

}
