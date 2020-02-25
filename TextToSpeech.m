import java.io.PrintWriter.*;
import java.sql.Connection.*;
import java.sql.DriverManager.*;
import java.sql.ResultSet.*;
import java.sql.Statement.*;
import java.util.Scanner.*;
userPrompt = 'What do you want the computer to say?';
titleBar = 'Text to Speech';
defaultString = 'Convert this to english';
store = inputdlg(userPrompt, titleBar, 1, {defaultString});
store = char(store);
fid = fopen('ny.txt','w');
fprintf(fid, store);
fclose(fid)
javaMethod('main',Try1,' ');

fid = fopen('C://shami/Mini Project//export.txt','r');

caUserInput = fscanf(fid,'%c');
if isempty(caUserInput)
	return;
end; % Bail out if they clicked Cancel.
caUserInput = char(caUserInput); % Convert from cell to string.
fclose(fid);

NET.addAssembly('System.Speech');
obj = System.Speech.Synthesis.SpeechSynthesizer;
obj.Volume = 100;
Speak(obj, caUserInput);