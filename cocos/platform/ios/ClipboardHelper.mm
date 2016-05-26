#import <UIKit/UIKit.h>
#import "ClipboardHelper.h"

#if CC_TARGET_PLATFORM == CC_PLATFORM_IOS

std::string ClipboardHelper::getClipboard()
{
	NSString *latest = [UIPasteboard generalPasteboard].string;
	std::string result = std::string([latest UTF8String]);
	return result;
}

void ClipboardHelper::setClipboard(const std::string &value)
{
    UIPasteboard *pasteboard = [UIPasteboard generalPasteboard];
    pasteboard.string = @(value.c_str());
}

#endif // CC_PLATFORM_IOS
