#ifndef IMPERIAL_CLIPBOARDHELPER_H
#define IMPERIAL_CLIPBOARDHELPER_H

#if CC_TARGET_PLATFORM == CC_PLATFORM_IOS

#include <string>
#include "platform/CCCommon.h"

class ClipboardHelper
{
    public:
        static std::string getClipboard();
        static void setClipboard(const std::string& value);
};

#endif // CC_PLATFORM_IOS

#endif
