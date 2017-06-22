package zjzt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class PicUploadAction extends ActionSupport {
	// ��װ�ϴ��ļ��������
	private File file;
	private String fileFileName;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	// ��������ע�������
		private String savePath;
		//ͼƬ�ϴ�������չʾ��ǰ׺
		private String imagePrefix;
		private String message="0";
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public void setImagePrefix(String imagePrefix) {
			this.imagePrefix = imagePrefix;
		}
		public String getSavePath() throws Exception {
			return ServletActionContext.getServletContext().getRealPath(savePath);
		}
		public void setSavePath(String savePath) {
			this.savePath = savePath;
		}
		
		
		
		/**
		 * �豸ͼƬ�ϴ�
		 * @return
		 */
		@SuppressWarnings("deprecation")
		public String uploadPic(){
			FileInputStream inputStream=null;
			FileOutputStream outputStream=null;		
			//�ϴ�ͼƬ�ı���·����savePath��action�����ļ����ж���
	        String path = ServletActionContext.getRequest().getRealPath(savePath);
	        File file = new File(path); // �ж��ļ����Ƿ����,����������򴴽��ļ���
	        if (!file.exists()) {
	            file.mkdir();
	        }
	        String[] fileSuffix = new String[] { ".exe" };// ��ֹ�ļ�
	        try {
	            File f = this.getFile();
	            //imageFileName=f.getName();
	            //MyPrintUtil.printError(fileFileName);            
	            // �ж��ļ���ʽ
	            for (int i = 0; i < fileSuffix.length; i++) {
	                if (fileFileName.endsWith(fileSuffix[i])) {
	                    message = "0";
	                    return ERROR;
	                }
	            }
	            inputStream = new FileInputStream(f);
	            outputStream = new FileOutputStream(path + "\\"+ fileFileName);
	            byte[] buf = new byte[1024];
	            int length = 0;
	            while ((length = inputStream.read(buf)) != -1) {
	                outputStream.write(buf, 0, length);
	            }
	            inputStream.close();
	            outputStream.flush();
	            message = imagePrefix + this.getFileFileName();
	        } catch (Exception e) {
	            e.printStackTrace();
	            message = "2";
	        }finally{
	        	close(outputStream, inputStream);
	        }
	        return SUCCESS;
	    }

		/**
		 * �ر��ļ����������
		 * 
		 * @param fos
		 * @param fis
		 */
		private void close(FileOutputStream fos, FileInputStream fis) {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("FileInputStream�ر�ʧ��");
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					System.out.println("FileOutputStream�ر�ʧ��");
					e.printStackTrace();
				}
			}
		}
	}
