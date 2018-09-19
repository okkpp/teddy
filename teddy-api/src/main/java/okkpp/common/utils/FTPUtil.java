package okkpp.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class FTPUtil {

	public void SFTPUpload(String HOST,int PORT,
			String UserName,String PassWord,
			String BASE_PATH,
			FileInputStream file,String fileName) {
		Session session = null;
        Channel channel = null;
        ChannelSftp chSftp = null;
        JSch jsch = new JSch();
        try {
			session = jsch.getSession(UserName, HOST, PORT);
			session.setPassword(PassWord);
	        session.setTimeout(100000);
	        Properties config = new Properties();
	        config.put("StrictHostKeyChecking", "no");
	        session.setConfig(config);
	        session.connect();
	        channel = session.openChannel("sftp");
	        channel.connect();
	        chSftp = (ChannelSftp) channel;
	        chSftp.put(file, BASE_PATH+fileName);
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();
		}  finally{
			chSftp.quit();
	        channel.disconnect();
	        session.disconnect();
		}
	}
	public void FTPUpload(String HOST,int PORT,
			String UserName,String PassWord,
			String BASE_PATH,
			FileInputStream file,String fileName) {
		FTPClient client = new FTPClient();
		try {
			client.connect(HOST, PORT);
			client.login(UserName, PassWord);
			client.changeWorkingDirectory(BASE_PATH);
			client.setFileType(FTP.BINARY_FILE_TYPE);
			client.storeFile(fileName, file);
			client.logout();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
